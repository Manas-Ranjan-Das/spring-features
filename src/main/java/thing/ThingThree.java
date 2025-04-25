package thing;

public class ThingThree {
    ThingOne thingOne;
    ThingTwo thingTwo;
    public ThingThree(ThingOne thingOne) {
        this.thingOne = thingOne;
    }
    public void setThingTwo(ThingTwo thingTwo) {
        this.thingTwo = thingTwo;
    }

    @Override
    public String toString() {
        return "thingOne = " + thingOne.size + "\nthingTwo = " + thingTwo.mass;
    }

}
