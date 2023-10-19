package ma.cigma.rest.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import ma.cigma.rest.service.model.Product;
/**
 * Il est recommandé d'annoter les classes de la couche métier par @Service
 * Spring injectera par la suite un objet de cette classe au niveau du contrôlleur.
 */
@Service
public class ProductServiceImpl implements IProductService {
    private static List<Product> productRepo = new ArrayList<>();

    static {
        productRepo.add(new Product(1l, "PC PORTABLE HP"));
        productRepo.add(new Product(2l, "TV LG 32p"));
        productRepo.add(new Product(3l, "TV Sony 49p"));
        productRepo.add(new Product(4l, "Camera Sony"));
    }

    @Override
    public Product getById(Long id) {
        if (productRepo == null || productRepo.isEmpty())
            return null;
        for (Product product : productRepo) {
            if (id.equals(product.getId()))
                return product;
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        return productRepo;
    }

    @Override
    public void update(Long id, Product product) {
        Product productFound = getById(id);
        if (productFound == null)
            return;
        productRepo.remove(productFound);
        product.setId(id);
        productRepo.add(product);
    }

    @Override
    public void delete(Long id) {
        Product productFound = getById(id);
        if (productFound == null)
            return;
        productRepo.remove(productFound);
    }
    @Override
    public void create(Product product) {
        productRepo.add(product);
    }
}