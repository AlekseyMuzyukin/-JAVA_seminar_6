import java.util.Comparator;

public class Laptop {
    String name;
    String manufacturer;
    String processor;
    Integer RAMGB;
    Integer HDDGB;
    String operatingSystem;
    String color;
    Integer price;
    Laptop(String name, String manufacturer, String processor, Integer RAMGB,
             Integer HDDGB, String operatingSystem, String color, Integer price){
        this.name = name;
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.RAMGB = RAMGB;
        this.HDDGB = HDDGB;
        this.operatingSystem = operatingSystem;
        this.color = color;
        this.price = price;
    }
    Laptop(){
        this.name = null;
        this.manufacturer = null;
        this.processor = null;
        this.RAMGB = 0;
        this.HDDGB = 0;
        this.operatingSystem = null;
        this.color = null;
        this.price = 0;
    }

    @Override
    public String toString() {
        return this.name + " | " + this.manufacturer + " | " + this.processor + " | " +
                this.RAMGB + " GB. | " + this.HDDGB + " GB. | " + this.operatingSystem + " | " +
                this.color + " | " + this.price;
    }
}

class NameCompare implements Comparator<Laptop> {
    @Override
    public int compare(Laptop o1, Laptop o2) {
        return o1.name.compareTo(o2.name);
    }
}

class ProcessorCompare implements Comparator<Laptop> {
    @Override
    public int compare(Laptop o1, Laptop o2) {
        return o1.processor.compareTo(o2.processor);
    }
}

class RAMCompare implements Comparator<Laptop> {
    @Override
    public int compare(Laptop o1, Laptop o2) {
        if(o1.RAMGB > o2.RAMGB) return 1;
        else return -1;
    }
}

class HDDCompare implements Comparator<Laptop> {
    @Override
    public int compare(Laptop o1, Laptop o2) {
        if(o1.HDDGB > o2.HDDGB) return 1;
        else return -1;
    }
}

class OSCompare implements Comparator<Laptop> {
    @Override
    public int compare(Laptop o1, Laptop o2) {
        return o1.operatingSystem.compareTo(o2.operatingSystem);
    }
}

class ColorCompare implements Comparator<Laptop> {
    @Override
    public int compare(Laptop o1, Laptop o2) {
        return o1.color.compareTo(o2.color);
    }
}

class PriceCompare implements Comparator<Laptop> {
    @Override
    public int compare(Laptop o1, Laptop o2) {
        if(o1.price > o2.price) return -1;
        else return 1;
    }
}