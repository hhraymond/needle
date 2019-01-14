package org.hhraymond.tesla;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountBuilder;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hhraymond
 * @since 2019-01-09
 */
public class KubeClient {
    private static final Logger logger = LoggerFactory.getLogger(KubeClient.class);

    public static void main(String[] args) throws InterruptedException {
        Config config = new ConfigBuilder().withMasterUrl("https://10.247.42.254:443")
                .withOauthToken("eyJhbGciOiJSUzI1NiIsImtpZCI6IiJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJueGJyYWluIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZWNyZXQubmFtZSI6Im54YnJhaW4tYWRtaW4tdG9rZW4td2x0OGwiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC5uYW1lIjoibnhicmFpbi1hZG1pbiIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50LnVpZCI6IjIxNmI4MzJiLTE0ODYtMTFlOS04ZGYyLTAyMDAyMWYxMDAyYyIsInN1YiI6InN5c3RlbTpzZXJ2aWNlYWNjb3VudDpueGJyYWluOm54YnJhaW4tYWRtaW4ifQ.O3-URUWRAMYZVL6jIeraktyC6o5hzjTq_z2rQ8S26oCt_CZWnOUwAhzOc8LiAcjC6XgwUxwaP7ZLtr8pjnU82pxcxZfEQogavNQlQ8PRkPzEg_CVcL1NtctWn_mnAaHglzC-aU8V7Lz-gSfrUahpeDL9wN9c166nNBd1mmuWAlm8qumiAUBO8fo4qDeVc3b-W3_ZS9puvO7ceIxA9RW-_qXDnThpAA39ZuoT5fdz3-fpXS6qS_eUyVjkHXzYtbJOg2_ap-NBSl_QZOtfE5zWhLD8drQxUJ2832u4A32o5XJOsFKkJEbn2SBNwoQ36q_FscDYIxePSP9EioBkfgC7KA")
                .withApiVersion("V1").withTrustCerts(true).build();
        KubernetesClient client = new DefaultKubernetesClient(config);

        try {
            // Create a namespace for all our stuff
            //Namespace ns = new NamespaceBuilder().withNewMetadata().withName("thisisatest").addToLabels("this", "rocks").endMetadata().build();
            //log("Created namespace", client.namespaces().createOrReplace(ns));

            ///ServiceAccount fabric8 = new ServiceAccountBuilder().withNewMetadata().withName("nxbrain").endMetadata().build();

            //client.serviceAccounts().inNamespace("nxbrain").createOrReplace(fabric8);

            Map<String, String> sele = new HashMap<>();
            sele.put("network", "calico");

            for (int i = 0; i < 2; i++) {
                System.err.println("Iteration:" + (i+1));
                Deployment deployment = new DeploymentBuilder()
                        .withNewMetadata()
                        .withName("nxbrain")
                        .endMetadata()
                        .withNewSpec()
                        .withReplicas(1)
                        .withNewTemplate()
                        .withNewMetadata()
                        .addToLabels("app", "nxbrain")
                        .endMetadata()
                        .withNewSpec()
                        .withNodeSelector(sele)
                        .addNewContainer()
                        .withName("nxbrain")
                        .withImage("st-docker.u51-inc.com/python27/captcha-ocr-train:7")
                        .addNewPort()
                        .withContainerPort(80)
                        .endPort()
                        .endContainer()
                        .endSpec()
                        .endTemplate()
                        .withNewSelector()
                        .addToMatchLabels("app", "nxbrain")
                        .endSelector()
                        .endSpec()
                        .build();


                deployment = client.apps().deployments().inNamespace("nxbrain").createOrReplace(deployment);
                log("Created deployment", deployment);

                System.err.println("Scaling up:" + deployment.getMetadata().getName());
                client.apps().deployments().inNamespace("nxbrain").withName("nxbrain").scale(2, true);
                log("Created replica sets:", client.apps().replicaSets().inNamespace("nxbrain").list().getItems());
                //System.err.println("Deleting:" + deployment.getMetadata().getName());
                //client.resource(deployment).delete();
            }
            log("Done.");

        }finally {
            //client.namespaces().withName("nxbrain").delete();
            client.close();
        }
    }


    private static void log(String action, Object obj) {
        logger.info("{}: {}", action, obj);
    }

    private static void log(String action) {
        logger.info(action);
    }
}
