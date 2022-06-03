import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    List<String> empty = new ArrayList<>();
    List<String> perfect = Arrays.asList("1","2","#","4","#5");
    List<String> e1 = Arrays.asList("1","0","#","1");
    List<String> e2 = Arrays.asList("0","2","#","1","#","3","0","2","#");
    List<String> actual = Arrays.asList("");




    private List<String> createList(String... elems){
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test

    void testEveryStatement(){
        IllegalArgumentException ex;
        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(empty));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));


        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(perfect));
        assertTrue(ex.getMessage().contains("List length should be a perfect square"));

        assertEquals(e1,SILab2.function(createList("1","2","#","3")));
        assertEquals(e2,SILab2.function(createList("1","2","#","3","#","5","6","7","#")));
    }

    @Test
    void testEveryPath(){
        IllegalArgumentException ex;
        // path : 1,2,3,26
        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(empty));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));

        //1,2,4,5,6,7,26

        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(perfect));
        assertTrue(ex.getMessage().contains("List length should be a perfect square"));

        //1,2,4,5,6,8,9.1,9.2,25,26 - can not test

        //1,2,4,5,6,8,9.1,9.2,22,23,24,9.3,9.2

        assertEquals(createList("0","0","0","0"),SILab2.function(createList("1","2","3","4")));

        //1,2,4,5,6,8,9.1,9.2,10,11,12,13,14,17
        assertEquals(createList("2","#","2","#","4","#","2","#","2"),SILab2.function(createList("1","#","2","#","4","#","5","#","6")));

        //1,2,4,5,6,8,9.1,9.2,10,11,12,15,17
        assertEquals(createList("0","2","#","1","#","3","0","2","#"),SILab2.function(createList("1","2","#","3","#","5","6","7","#")));

        //1,2,4,5,6,8,9.1,9.2,10,11,12,16,17,18,26
        assertEquals(createList("1","#","1","#"),SILab2.function(createList("1","#","2","#")));

        //1,2,4,5,6,8,9.1,9.2,10,11,17,18,19,20,21,26
        assertEquals(createList("1","#","1","#"),SILab2.function(createList("1","#","2","#")));

    }

    @Test
    void multipleConditionTest(){
        IllegalArgumentException ex;
        //((i % rootOfN != 0 && list.get(i - 1).equals("#")) || (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")))

        //((i % rootOfN != 0 && list.get(i - 1).equals("#")) && (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")))

        //(T&&T) || T
        //(T&&T) || F
        //(T&&F) || T
        //(F&&T) || T

        //(T&&T)&&T
        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(empty));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));

        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(perfect));
        assertTrue(ex.getMessage().contains("List length should be a perfect square"));

        assertEquals(createList("2","#","2","#","4","#","2","#","2"),SILab2.function(createList("1","#","2","#","4","#","5","#","6")));


    }

}