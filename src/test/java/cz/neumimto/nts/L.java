package cz.neumimto.nts;

import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static cz.neumimto.nts.annotations.ScriptMeta.*;

@Function("list")
public class L {

    @Handler
    public Iterable c(@NamedParam("size") int q) {
        return IntStream.range(0, q).mapToObj(a->UUID.randomUUID()).collect(Collectors.toList());
    }
}
