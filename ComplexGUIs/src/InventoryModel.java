import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * A model of a product inventory application.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class InventoryModel {
    /**
     * The product list of this inventory model.
     */
    private List<Product> productList;

    /**
     * Constructs a newly allocated {@code InventoryModel} object.
     */
    public InventoryModel() {
        this.productList = new ArrayList<>();
    } //InventoryModel

    /**
     * Determines whether or not this inventory model contains the specified product. The search is case-insensitive.
     *
     * @param aProduct the product to be searched for
     * @return {@code true}, if this inventory model contains the specified product, and {@code false} otherwise
     * @throws IllegalArgumentException if the {@code aProduct} argument is {@code null}
     */
    public boolean contains(Product aProduct) throws IllegalArgumentException {
        if (aProduct == null) {
            throw new IllegalArgumentException("aProduct argument is null");
        } else {
            for (Product product : this.productList) {
                if (product.getSku() == null ? aProduct.getSku() == null : product.getSku().equalsIgnoreCase(aProduct.getSku())) {
                    return true;
                } //end if
            } //end for

            return false;
        } //end if
    } //contains

    /**
     * Attempts to add the specified product to this inventory model. If the specified product is already a member of
     * this model, it will not be added.
     *
     * @param aProduct the product attempting to be added
     * @return {@code true}, if the specified product was successfully added, and {@code false} otherwise
     * @throws IllegalArgumentException if the {@code aProduct} argument is {@code null}
     */
    public boolean add(Product aProduct) throws IllegalArgumentException {
        if (aProduct == null) {
            throw new IllegalArgumentException("aProduct argument is null");
        } else if (this.contains(aProduct)) {
            return false;
        } else {
            this.productList.add(aProduct);

            return true;
        } //end if
    } //add

    /**
     * Attempts to remove the specified product from this inventory model. If the specified product is not a member of
     * this model, no products will be removed.
     *
     * @param aProduct the product attempting to be removed
     * @return {@code true}, if the specified product was successfully removed, and {@code false} otherwise
     * @throws IllegalArgumentException if the {@code aProduct} argument is {@code null}
     */
    public boolean remove(Product aProduct) throws IllegalArgumentException {
        return this.productList.remove(aProduct);
    } //remove

    /**
     * Searches for a product with the specified SKU in this inventory model. The search is case-insensitive.
     *
     * @param sku the SKU to be searched for
     * @return an {@code Optional} containing the product with the specified SKU, or an empty {@code Optional} if the
     * product was not found
     */
    public Optional<Product> searchBySku(String sku) {
        return this.productList.stream()
                               .filter(product -> (product.getSku() == null ? sku == null : product.getSku().equalsIgnoreCase(sku)))
                               .findAny();
    } //searchBySku

    /**
     * Searches for products with the specified name in this inventory model. The search is case-insensitive.
     *
     * @param name the name to be searched for
     * @return a {@code List} containing products with the specified name
     */
    public List<Product> searchByName(String name) {
        return this.productList.stream()
                               .filter(product -> (product.getName() == null ? name == null : product.getName().equalsIgnoreCase(name)))
                               .collect(Collectors.toList());
    } //searchByName

    /**
     * Searches for products with the specified wholesale price in this inventory model.
     *
     * @param wholesalePrice the wholesale price to be searched for
     * @return a {@code List} containing products with the specified wholesale price
     */
    public List<Product> searchByWholesalePrice(double wholesalePrice) {
        return this.productList.stream()
                               .filter(product -> (Double.compare(product.getWholesalePrice(), wholesalePrice) == 0))
                               .collect(Collectors.toList());
    } //searchByWholesalePrice

    /**
     * Searches for products with the specified retail price in this inventory model.
     *
     * @param retailPrice the retail price to be searched for
     * @return a {@code List} containing products with the specified retail price
     */
    public List<Product> searchByRetailPrice(double retailPrice) {
        return this.productList.stream()
                               .filter(product -> (Double.compare(product.getRetailPrice(), retailPrice) == 0))
                               .collect(Collectors.toList());
    } //searchByRetailPrice

    /**
     * Searches for products with the specified quantity in this inventory model.
     *
     * @param quantity the quantity to be searched for
     * @return a {@code List} containing products with the specified quantity
     */
    public List<Product> searchByQuantity(int quantity) {
        return this.productList.stream()
                               .filter(product -> (product.getQuantity() == quantity))
                               .collect(Collectors.toList());
    } //searchByQuantity

    /**
     * Gets the hash code of this inventory model.
     *
     * @return the hash code of this inventory model
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.productList == null ? 0 : this.productList.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this inventory model is equal to the specified object. {@code true} is returned if and
     * only if the specified object is an instance of {@code InventoryModel}, and its field values are equal to this
     * inventory model's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this inventory model is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof InventoryModel)
                && (this.productList == null ? ((InventoryModel) anObject).productList == null : this.productList.equals(((InventoryModel) anObject).productList));
    } //equals

    /**
     * Gets a {@code String} representation of this inventory model. The returned {@code String} is of the form
     * {@code InventoryModel[p]}, where {@code p} is the list of products contained in this inventory model.
     *
     * @return a {@code String} representation of this inventory model
     */
    @Override
    public String toString() {
        return (this.productList == null ? "InventoryModel[]" : String.format("InventoryModel%s", this.productList));
    } //toString
}