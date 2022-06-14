public class Main {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1, "Отцы и дети", 800, "Тургенев");
        Smartphone smartphone1 = new Smartphone(2, "iPhone SE", 50000, "Apple");
        Book book2 = new Book(3, "Война и Мир", 5000, "Толстой");

        Smartphone smartphone2 = new Smartphone(4, "Galaxy S 10", 60000, "Samsung");
        Book book3 = new Book(5, "Преступление и наказание", 3000, "Достоевский");
        Smartphone smartphone3 = new Smartphone(6, "Mi Not 10 Light", 30000, "Xiaomi");

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
        manager.add(book3);
        manager.add(smartphone3);

        //Проверка отображения исключения NotFoundException
        repository.removeById(7);

        //Проверка отображения исключения AlreadyExistsException
        //Smartphone smartphone4 = new Smartphone(6, "P10", 30000, "Honor");
        //manager.add(smartphone4);



    }
}
