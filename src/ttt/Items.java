package ttt;

  class Items<T> {

        T element;

       Items<T> nextItem;

        Items<T> prevItem;

    Items(final T element, final Items<T> prevItem, final Items<T> nextItem) {
        this.element = element;
        this.nextItem = nextItem;
        this.prevItem = prevItem;
    }


    public Items<T> getNextItem() {
        return nextItem;
    }

    public Items<T> getPrevItem() {
        return prevItem;
    }
}