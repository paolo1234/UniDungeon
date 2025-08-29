package com.unidungeon.item;
import java.util.Iterator;
import java.util.List;

public class ItemIterator implements Iterator<Integer> {

    private List<Item> items;
    private int currentIndex;

    public ItemIterator(List<Item> items) {
        this.items = items;
        this.currentIndex = 0;
    }

    public void resetIterator(){
        if(items.size() > 0){
            currentIndex = 0;
        }
    }

    @Override
    public boolean hasNext() {
        return items.size() > 0;
    }

    @Override
    public Integer next() {
        if (currentIndex < items.size() - 1) {
            currentIndex++;
        }else {
            currentIndex = 0;
        }
        //return items.get(currentIndex);
        return currentIndex;
    }

    public Integer previous() {
        if (currentIndex > 0) {
            currentIndex--;
        }else {
            currentIndex = items.size() - 1;
        }
        //return items.get(currentIndex);
        return currentIndex;
    }

    public Integer removeItem() {
        if(items.size() > 0){
            items.remove(currentIndex);
            if(currentIndex > 0)
                currentIndex--;
        }
        return currentIndex;
    }
}
