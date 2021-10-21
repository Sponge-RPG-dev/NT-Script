package cz.neumimto.nts;

import java.lang.reflect.Executable;
import java.util.List;

public class Descriptor {
    public final Executable executable;
    public final List<String> namedParams;
    public final String functionName;
    public final boolean injectedViaField;

    public Descriptor(Executable executable, String functionName, List<String> namedParams, boolean injectedViaField) {
        this.executable = executable;
        this.namedParams = namedParams;
        this.functionName = functionName;
        this.injectedViaField = injectedViaField;
    }
}
