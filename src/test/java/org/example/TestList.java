package org.example;

import org.example.collections.CustomArrayList;
import org.example.struct.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    private List list;
    private int value;
    private Condom testCon;
    @Before
    public void setUp(){
        value = 5;
        list = new CustomArrayList();
        testCon = new Condom(Condom.Firm.CONTEX, 100);
        for(int i = 0; i < value; i++){
            list.add(new Condom(Condom.Firm.values()[i % 4], i));
        }
        list.add(testCon);
        value++;
    }

    @Test
    public void checkSizeListAfterInitFunction(){
        assertEquals(value, list.size());
    }

    @Test
    public void whenElementRemoveByIndexThenSizeMustBeDecreased(){
        assertTrue(list.remove(testCon));
        value--;
        assertEquals(value, list.size());
    }
    @Test
    public void whenAddElementInEndBySizeMustIncreased(){
        assertTrue(list.add(testCon));
        value++;
        assertEquals(value, list.size());
    }

    @Test
    public void whenAddElementInMiddleCollectionsByGetTrueAndGetMethodReturnEqualseObject(){
        int position = value / 2;
        list.add(position, testCon);
        value++;
        assertEquals(testCon,list.get(position));
    }

    @Test
    public void whenUseAddAll10EllementsByLast10ElementsIsDurexPart1(){
        List donorList = new ArrayList<Condom>();
        Condom testAddAllCondom = new Condom(Condom.Firm.DUREX,1);
        for (int i = 0; i < 10; i++){
            list.add(testAddAllCondom);
        }
        assertTrue(list.addAll(donorList));
        for(int i = list.size() - 1; i > list.size() - 11; i--){
            assertEquals(testAddAllCondom, list.get(i));
        }
    }

/*
remove
add
get
addAll
 */
}
