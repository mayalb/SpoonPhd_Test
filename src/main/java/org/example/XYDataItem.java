package org.example;

import java.util.ArrayList;
import java.util.List;
public class XYDataItem {

    private List<XYDataItem> data;
    private boolean allowDuplicateXValues;
    private boolean autoSort;
    private int maximumItemCount;

    public XYDataItem() {
        data = new ArrayList<>();
    }

    public XYDataItem(Number x, Number y) {
        // Implementation of constructor
    }

    public XYDataItem addOrUpdate(Number x, Number y) {
        if (x == null) {
            throw new IllegalArgumentException("Null 'x' argument.");
        }
        XYDataItem overwritten = null;
        int index = indexOf(x);
        if (index >= 0 && !this.allowDuplicateXValues) {
            XYDataItem existing = this.data.get(index);
            try {
                overwritten = existing.clone();
            } catch (CloneNotSupportedException e) {
                throw new SeriesException("Couldn't clone XYDataItem!");
            }
            existing.setY(y);
        } else {
            if (this.autoSort) {
                this.data.add(-index - 1, new XYDataItem(x, y));
            } else {
                this.data.add(new XYDataItem(x, y));
            }
            if (getItemCount() > this.maximumItemCount) {
                this.data.remove(0);
            }
        }
        fireSeriesChanged();
        return overwritten;
    }

    private int indexOf(Number x) {
        // Implementation of indexOf method
        return 0;
    }

    private void fireSeriesChanged() {

    }

    private int getItemCount() {

        return data.size();
    }

    private void setY(Number y) {

    }

    protected XYDataItem clone() throws CloneNotSupportedException {
        return (XYDataItem) super.clone();
    }

    static class SeriesException extends RuntimeException {
        SeriesException(String message) {
            super(message);
        }
    }
}