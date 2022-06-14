public class Smartphone extends Product{
    private String manufacturer;

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(Product product, String search) {
        if(super.matches(product, search)){
            return true;
        }
        if (manufacturer.contains(search)) {
            return true;
        }
        return false;
    }

}
