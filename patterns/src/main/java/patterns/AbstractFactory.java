package patterns;

public class AbstractFactory {
    public static void main(String[] args) {
        DeviceFactory factory = getFactoryByCountryCode("RU");

        Mouse m = factory.getMouse();
        Keyboad k = factory.getKeyboad();

        m.click();
        k.print();
    }

    public static DeviceFactory getFactoryByCountryCode(String code) {

        switch (code) {
            case "RU":
                return new RUDeviceFactory();
            case "EN":
                return new ENDeviceFactory();
            default:
                throw new RuntimeException("It is not correct");
        }
    }

    public static class RUDeviceFactory implements DeviceFactory {

        @Override
        public Mouse getMouse() {
            return new RuMouse();
        }

        @Override
        public Keyboad getKeyboad() {
            return new RuKeyboard();
        }
    }

    public static class ENDeviceFactory implements DeviceFactory {

        @Override
        public Mouse getMouse() {
            return new EnMouse();
        }

        @Override
        public Keyboad getKeyboad() {
            return new EnKeyboard();
        }
    }

    public interface DeviceFactory {
        Mouse getMouse();

        Keyboad getKeyboad();
    }

    public interface Mouse {
        void click();
    }

    public interface Keyboad {
        void print();
    }

    public static class RuMouse implements Mouse {

        @Override
        public void click() {
            System.out.println("Клик");
        }
    }

    public static class EnMouse implements Mouse {

        @Override
        public void click() {
            System.out.println("Click");
        }
    }

    public static class RuKeyboard implements Keyboad {

        @Override
        public void print() {
            System.out.println("єто клава");
        }
    }


    public static class EnKeyboard implements Keyboad {
        @Override
        public void print() {
            System.out.println("it's keyboard");
        }
    }
}
