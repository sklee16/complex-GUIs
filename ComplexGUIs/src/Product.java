/**
 * A product in a company's inventory.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class Product {
    /**
     * The SKU of this product.
     */
    private String sku;

    /**
     * The name of this product.
     */
    private String name;

    /**
     * The wholesale price of this product.
     */
    private double wholesalePrice;

    /**
     * The retail price of this product.
     */
    private double retailPrice;

    /**
     * The quantity of this product.
     */
    private int quantity;

    /**
     * Constructs a newly allocated {@code Product} object with a default SKU of {@code null}, name of {@code null},
     * wholesale price of {@code 0.0}, retail price of {@code 0.0}, and quantity of {@code 0}.
     */
    public Product() {
        this(null, null, 0.0, 0.0, 0);
    } //Product

    /**
     * Constructs a newly allocated {@code Product} object that is a copy of the specified product.
     *
     * @param aProduct the product to be copied
     * @throws IllegalArgumentException if the {@code aProduct} argument is {@code null}
     */
    public Product(Product aProduct) throws IllegalArgumentException {
        if (aProduct == null) {
            throw new IllegalArgumentException("aProduct argument is null");
        } else {
            this.sku = aProduct.sku;
            this.name = aProduct.name;
            this.wholesalePrice = aProduct.wholesalePrice;
            this.retailPrice = aProduct.retailPrice;
            this.quantity = aProduct.quantity;
        } //end if
    } //Product

    /**
     * Constructs a newly allocated {@code Product} object with the specified SKU, name, wholesale price, retail price,
     * and quantity.
     *
     * @param sku the SKU of this product
     * @param name the name of this product
     * @param wholesalePrice the wholesale price of this product
     * @param retailPrice the retail price of this product
     * @param quantity the quantity of this product
     * @throws IllegalArgumentException if the {@code wholesalePrice} argument, {@code retailPrice} argument, or
     * {@code quantity} argument is negative
     */
    public Product(String sku, String name, double wholesalePrice, double retailPrice, int quantity) throws IllegalArgumentException {
        if (Double.compare(wholesalePrice, 0.0) < 0) {
            throw new IllegalArgumentException("wholesalePrice argument is negative");
        } else if (Double.compare(retailPrice, 0.0) < 0) {
            throw new IllegalArgumentException("retailPrice argument is negative");
        } else if (quantity < 0) {
            throw new IllegalArgumentException("quantity argument is negative");
        } else {
            this.sku = sku;
            this.name = name;
            this.wholesalePrice = wholesalePrice;
            this.retailPrice = retailPrice;
            this.quantity = quantity;
        } //end if
    } //Product

    /**
     * Gets the SKU of this product.
     *
     * @return the SKU of this product
     */
    public String getSku() {
        return this.sku;
    } //getSku

    /**
     * Gets the name of this product.
     *
     * @return the name of this product
     */
    public String getName() {
        return this.name;
    } //getName

    /**
     * Gets the wholesale price of this product.
     *
     * @return the wholesale price of this product
     */
    public double getWholesalePrice() {
        return this.wholesalePrice;
    } //getWholesalePrice

    /**
     * Gets the retail price of this product.
     *
     * @return the retail price of this product
     */
    public double getRetailPrice() {
        return this.retailPrice;
    } //getRetailPrice

    /**
     * Gets the quantity of this product.
     *
     * @return the quantity of this product
     */
    public int getQuantity() {
        return this.quantity;
    } //getQuantity

    /**
     * Sets the SKU of this product.
     *
     * @param sku the SKU of this product
     */
    public void setSku(String sku) {
        this.sku = sku;
    } //setSku

    /**
     * Sets the name of this product.
     *
     * @param name the name of this product
     */
    public void setName(String name) {
        this.name = name;
    } //setName

    /**
     * Sets the wholesale price of this product.
     *
     * @param wholesalePrice the wholesale price of this product
     * @throws IllegalArgumentException if the {@code wholesalePrice} argument is negative
     */
    public void setWholesalePrice(double wholesalePrice) throws IllegalArgumentException {
        if (Double.compare(wholesalePrice, 0.0) < 0) {
            throw new IllegalArgumentException("wholesalePrice argument is negative");
        } else {
            this.wholesalePrice = wholesalePrice;
        } //end if
    } //setWholesalePrice

    /**
     * Sets the retail price of this product.
     *
     * @param retailPrice the retail price of this product
     * @throws IllegalArgumentException if the {@code retailPrice} argument is negative
     */
    public void setRetailPrice(double retailPrice) throws IllegalArgumentException {
        if (Double.compare(retailPrice, 0.0) < 0) {
            throw new IllegalArgumentException("retailPrice argument is negative");
        } else {
            this.retailPrice = retailPrice;
        } //end if
    } //setRetailPrice

    /**
     * Sets the quantity of this product.
     *
     * @param quantity the quantity of this product
     * @throws IllegalArgumentException if the {@code quantity} argument is negative
     */
    public void setQuantity(int quantity) throws IllegalArgumentException {
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity argument is negative");
        } else {
            this.quantity = quantity;
        } //end if
    } //setQuantity

    /**
     * Gets the hash code of this product.
     *
     * @return the hash code of this product
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.sku == null ? 0 : this.sku.hashCode());

        result = 19 * result + (this.name == null ? 0 : this.name.hashCode());

        result = 19 * result + ((int) (Double.doubleToLongBits(this.wholesalePrice) ^ (Double.doubleToLongBits(this.wholesalePrice) >>> 32)));

        result = 19 * result + ((int) (Double.doubleToLongBits(this.retailPrice) ^ (Double.doubleToLongBits(this.retailPrice) >>> 32)));

        result = 19 * result + this.quantity;

        return result;
    } //hashCode

    /**
     * Determines whether or not this product and the specified object are equal. {@code true} is returned if and only
     * if the specified object is an instance of {@code Product}, and its SKU, name, wholesale price, retail price, and
     * quantity are equal to this product's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this product is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof Product)
                && (this.sku == null ? ((Product) anObject).sku == null : this.sku.equals(((Product) anObject).sku))
                && (this.name == null ? ((Product) anObject).name == null : this.name.equals(((Product) anObject).name))
                && (Double.compare(this.wholesalePrice, ((Product) anObject).wholesalePrice) == 0)
                && (Double.compare(this.retailPrice, ((Product) anObject).retailPrice) == 0)
                && (this.quantity == ((Product) anObject).quantity);
    } //equals

    /**
     * Gets a {@code String} representation of this product.
     *
     * @return a {@code String} representation of this product
     */
    @Override
    public String toString() {
        String outString = "";

        outString += String.format("SKU: %s\n", this.sku);

        outString += String.format("Name: %s\n", this.name);

        outString += String.format("Wholesale price: $%.2f\n", this.wholesalePrice);

        outString += String.format("Retail price: $%.2f\n", this.retailPrice);

        outString += String.format("Quantity: %d", this.quantity);

        return outString;
    } //toString
}