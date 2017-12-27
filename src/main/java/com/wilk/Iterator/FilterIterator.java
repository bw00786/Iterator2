package com.wilk.Iterator;

import java.util.Iterator;

public class FilterIterator implements Iterator<Object>

{
    private final Iterator<Object> wrapped;
    private final IObjectTest predicate;
    private Object next;

    public FilterIterator(Iterator<Object> wrapped, IObjectTest predicate) {
        this.wrapped = wrapped;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        while (next == null && wrapped.hasNext()) {
            next = wrapped.next();
            if (predicate.test(next))
                return true;
            next = null;
        }
        return next != null;
    }

    @Override
    public Object next() {
        if (next == null)
            hasNext();
        try {
            return next;
        } finally {
            next = null;
            hasNext();
        }
    }

    @Override
    public void remove() {
        wrapped.remove();
    }
}
