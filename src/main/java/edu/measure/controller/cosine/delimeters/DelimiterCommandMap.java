package edu.measure.controller.cosine.delimeters;

import edu.measure.controller.cosine.DelimiterCommand;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static edu.measure.controller.util.Constants.*;

/**
 * impl of command map pattern
 */
public class DelimiterCommandMap {
    private Map<String, DelimiterCommand> delimiterCommandMap;

    public DelimiterCommandMap() {
        final DelimiterExecutors delimiterExecutors = new DelimiterExecutors();
        delimiterCommandMap = new LinkedHashMap<>();
        delimiterCommandMap.put(RECALL_OPTION, delimiterExecutors::recallCommand);
        delimiterCommandMap.put(PRECISION_OPTION, delimiterExecutors::precisionCommand);
        delimiterCommandMap.put(FONE_OPTION, delimiterExecutors::fOneCommand);
        delimiterCommandMap.put(ACCURACY_OPTION, delimiterExecutors::accuracyCommand);
        delimiterCommandMap.put(EXPERT_EDGES_OPTION, (expertEdges, cosineValuesMap) -> delimiterExecutors.expertEdgeCommand(expertEdges));

    }

    public Map<String, DelimiterCommand> getDelimiterCommandMap() {
        return delimiterCommandMap;
    }
    public Set<String> getCommands() {
        return delimiterCommandMap.keySet();
    }
}
