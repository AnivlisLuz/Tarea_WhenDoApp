package factoryDevices;

public class FactoryDevices {
    public enum DeviceType{
        ANDROID,
        IOS,
        WINDOW_PHONE
    }
    public static IDevice make (DeviceType type){
        IDevice device;

        switch (type){
            case ANDROID:
                device= new Android();
                break;
            case IOS:
                device= new IOS();
                break;
            case WINDOW_PHONE:
                device= new WindowPhone();
                break;
            default:
                device = new Android();
                break;
        }
        return device;
    }
}
