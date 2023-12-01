import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> argsMap = parseArguments(args);

        String task = argsMap.getOrDefault("task", "traffic_state_pred");
        String model = argsMap.getOrDefault("model", "GRU");
        String dataset = argsMap.getOrDefault("dataset", "METR_LA");
        String configFile = argsMap.get("config_file");
        boolean savedModel = Boolean.parseBoolean(argsMap.getOrDefault("saved_model", "true"));
        boolean train = Boolean.parseBoolean(argsMap.getOrDefault("train", "true"));

        Map<String, String> otherArgs = getOtherArgs(argsMap);

        // Set CUDA_VISIBLE_DEVICES if gpu_id is provided
        String gpuId = argsMap.get("gpu_id");
        if (gpuId != null) {
            System.setProperty("CUDA_VISIBLE_DEVICES", gpuId);
        }

        // Run the model
        runModel(task, model, dataset, configFile, savedModel, train, otherArgs);
    }

    private static Map<String, String> parseArguments(String[] args) {
        Map<String, String> argsMap = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            argsMap.put(args[i].substring(2), args[i + 1]);
        }
        return argsMap;
    }

    private static Map<String, String> getOtherArgs(Map<String, String> argsMap) {
        Map<String, String> otherArgs = new HashMap<>();
        for (Map.Entry<String, String> entry : argsMap.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();
            if (!List.of("task", "model", "dataset", "config_file", "saved_model", "train").contains(key) && val != null) {
                otherArgs.put(key, val);
            }
        }
        return otherArgs;
    }

    private static void runModel(String task, String model, String dataset, String configFile,
                                 boolean savedModel, boolean train, Map<String, String> otherArgs) {
        // Implement the logic for running the model here
        // You may want to call methods or instantiate classes based on the provided parameters
        // ...
    }
}
