import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductManagerTest {
    Book book1 = new Book(1, "Отцы и дети", 800, "Тургенев");
    Smartphone smartphone1 = new Smartphone(2, "iPhone SE", 50000, "Apple");
    Book book2 = new Book(3, "Война и Мир", 5000, "Толстой");

    Smartphone smartphone2 = new Smartphone(4, "Galaxy S 10", 60000, "Samsung");
    Book book3 = new Book(5, "Преступление и наказание", 3000, "Достоевский");
    Smartphone smartphone3 = new Smartphone(6, "Mi Not 10 Light", 30000, "Xiaomi");

    Smartphone smartphone4 = new Smartphone(6, "P10", 30000, "Honor");

    @Test
    public void mustAdd() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(smartphone1);

        Product[] actual = manager.searchBy("ен");
        Product[] expected = {book1};

        assertArrayEquals(expected, actual);

    }

    @Test
    public void mustSearchBy() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
        manager.add(book3);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("ho");
        Product[] expected = {smartphone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void mustSearchBySmartPhoneManufacture() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
        manager.add(book3);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("a");
        Product[] expected = {smartphone2, smartphone3};

        assertArrayEquals(expected, actual);
    }
    @Test
    public void mustSearchByBookAuthor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
        manager.add(book3);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("т");
        Product[] expected = {book1, book2, book3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void mustSearchByNoMatches() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
        manager.add(book3);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("я");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void mustFindAll() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
        manager.add(book3);
        manager.add(smartphone3);

        Product[] actual = repository.findAll();
        Product[] expected = { book1, smartphone1, book2, smartphone2, book3, smartphone3 };

        assertArrayEquals(expected, actual);

    }
    //Добаление 2-х автотестов
    @Test //Проверка успешности удаления существующего элемента
    public void shouldRemoveById() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
        manager.add(book3);
        manager.add(smartphone3);

        repository.removeById(1); //просим удалить
        repository.removeById(3);
        repository.removeById(4);

        Product[] actual = repository.findAll();
        Product[] expected = { smartphone1, book3, smartphone3 };


        Assertions.assertArrayEquals(expected, actual);
    }
    @Test // генерация NotFoundException при попытке удаления несуществующего элемента
    public void shouldRemoveByIdNotFoundId() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
        manager.add(book3);
        manager.add(smartphone3);


    assertThrows(NotFoundException.class, () -> {repository.removeById(7);});
    }

    @Test // генерация AlreadyExistsException при попытке добавить элемент с повторяющимся id
    public void mustAddAlreadyExistsId() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
        manager.add(book3);
        manager.add(smartphone3);

        assertThrows(AlreadyExistsException.class, () -> {manager.add(smartphone4);});

    }
    @Test //Проверка успешности добавления новых товаров
    public void mustAddNonAlreadyExists() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
        manager.add(book3);
        manager.add(smartphone3);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, smartphone1, book2, smartphone2, book3, smartphone3};

        assertArrayEquals(expected, actual);

    }

}


