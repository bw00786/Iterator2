package com.wilk.test.iterators;

import com.wilk.Iterator.FilterIterator;
import com.wilk.Iterator.IObjectTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
public class FilterIteratorTest {
    @Test
    public void filtersOdds() {
        List<Object> numbers = Arrays.<Object>asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IObjectTest oddsOnly = new IObjectTest() {
            @Override
            public boolean test(Object o) {
                return ((Integer)o) % 2 != 0;
            }
        };
        Iterator<Object> odds = new FilterIterator(numbers.iterator(), oddsOnly);
        assertEquals(1, odds.next());
        assertEquals(3, odds.next());
        assertEquals(5, odds.next());
        assertEquals(7, odds.next());
        assertEquals(9, odds.next());
        assertFalse(odds.hasNext());
    }
}
