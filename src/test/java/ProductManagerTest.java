import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import ru.netology.AlreadyExistsException;
import ru.netology.NotFoundException;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductManagerTest {

    @Test
    public void shouldRemoveById() {

        Repository repository = new Repository();
        Product book1 = new Book(1, "Capital", 1000, "K.Marks");
        Product smartphone1 = new Smartphone(2, "N80", 14000, "Nokia");
        Product book2 = new Book(3, "Red Sails", 3000, "A.Green");
        repository.add(book1);
        repository.add(smartphone1);
        repository.add(book2);
        repository.removeById(2);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveNotFound() {
        Repository repository = new Repository();
        Product book1 = new Book(1, "Capital", 1000, "K.Marks");
        Product smartphone1 = new Smartphone(2, "N80", 14000, "Nokia");
        Product book2 = new Book(3, "Red Sails", 3000, "A.Green");
        repository.add(book1);
        repository.add(smartphone1);
        repository.add(book2);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(4);
        });
    }

    @Test
    public void shouldAddProduct() {
        Repository repository = new Repository();
        Product book1 = new Book(1, "Capital", 1000, "K.Marks");
        Product smartphone1 = new Smartphone(2, "N80", 14000, "Nokia");
        Product book2 = new Book(3, "Red Sails", 3000, "A.Green");
        repository.add(book1);
        repository.add(smartphone1);
        repository.add(book2);
        Product[] actual = repository.findAll();
        Product[] expected = {book1, smartphone1, book2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddProductWithExistingId() {
        Repository repository = new Repository();
        Product book1 = new Book(1, "Capital", 1000, "K.Marks");
        Product smartphone1 = new Smartphone(2, "N80", 14000, "Nokia");
        Product book2 = new Book(3, "Red Sails", 3000, "A.Green");
        repository.add(book1);
        repository.add(smartphone1);
        repository.add(book2);
        assertThrows(AlreadyExistsException.class, () -> {
            repository.add(new Book(3, "Black Sails", 3001, "A.Blue"));
        });
    }

}