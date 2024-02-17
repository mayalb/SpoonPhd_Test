package org.example;
public class XYDataItem {
    private java.util.List<org.example.XYDataItem> data;

    private boolean allowDuplicateXValues;

    private boolean autoSort;

    private int maximumItemCount;

    public XYDataItem() {
        data = new java.util.ArrayList<>();
    }

    public XYDataItem(java.lang.Number x, java.lang.Number y) {
        // Implementation of constructor
    }

    public org.example.XYDataItem addOrUpdate(java.lang.Number x, java.lang.Number y) {
        if (x == null) {
            throw new java.lang.IllegalArgumentException("Null 'x' argument.");
        }
        org.example.XYDataItem overwritten = null;
        int index = indexOf(x);
        if ((index >= 0) && (!this.allowDuplicateXValues)) {
            org.example.XYDataItem existing = this.data.get(index);
            try {
                overwritten = existing.clone();
            } catch (java.lang.CloneNotSupportedException e) {
                throw new org.example.XYDataItem.SeriesException("Couldn't clone XYDataItem!");
            }
            existing.setY(y);
        } else {
            if (this.autoSort) {
                this.data.add((-index) - 1, new org.example.XYDataItem(x, y));
            } else {
                this.data.add(new org.example.XYDataItem(x, y));
            }
            if (getItemCount() > this.maximumItemCount) {
                this.data.remove(0);
            }
        }
        fireSeriesChanged();
        return overwritten;
    }

    private int indexOf(java.lang.Number x) {
        // Implementation of indexOf method
        return 0;
    }

    private void fireSeriesChanged() {
        // Implementation of fireSeriesChanged method
    }

    private int getItemCount() {
        // Implementation of getItemCount method
        return data.size();
    }

    private void setY(java.lang.Number y) {
        // Implementation of setY method
    }

    protected org.example.XYDataItem clone() throws java.lang.CloneNotSupportedException {
        // Implementation of clone method
        return ((org.example.XYDataItem) (super.clone()));
    }

    static class SeriesException extends java.lang.RuntimeException {
        SeriesException(java.lang.String message) {
            super(message);
        }
    }
}