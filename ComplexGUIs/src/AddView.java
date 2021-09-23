import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * An add view of a product inventory application.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class AddView {
    /**
     * The main panel of this add view.
     */
    private JPanel mainPanel;

    /**
     * The SKU text field of this add view.
     */
    private JTextField skuTextField;

    /**
     * The name text field of this add view.
     */
    private JTextField nameTextField;

    /**
     * The wholesale price text field of this add view.
     */
    private JTextField wholesalePriceTextField;

    /**
     * The retail price text field of this add view.
     */
    private JTextField retailPriceTextField;

    /**
     * The quantity text field of this add view.
     */
    private JTextField quantityTextField;

    /**
     * The add button of this add view.
     */
    private JButton addButton;

    /**
     * The clear button of this add view.
     */
    private JButton clearButton;

    /**
     * Constructs a newly allocated {@code AddView} object.
     */
    public AddView() {
        //
    } //AddView

    /**
     * Gets the main panel of this add view.
     *
     * @return the main panel of this add view
     */
    public JPanel getMainPanel() {
        return this.mainPanel;
    } //getMainPanel

    /**
     * Gets the SKU text field of this add view.
     *
     * @return the SKU text field of this add view
     */
    public JTextField getSkuTextField() {
        return this.skuTextField;
    } //getSkuTextField

    /**
     * Gets the name text field of this add view.
     *
     * @return the name text field of this add view
     */
    public JTextField getNameTextField() {
        return this.nameTextField;
    } //getNameTextField

    /**
     * Gets the wholesale price text field of this add view.
     *
     * @return the wholesale price text field of this add view
     */
    public JTextField getWholesalePriceTextField() {
        return this.wholesalePriceTextField;
    } //getWholesalePriceTextField

    /**
     * Gets the retail price text field of this add view.
     *
     * @return the retail price text field of this add view
     */
    public JTextField getRetailPriceTextField() {
        return this.retailPriceTextField;
    } //getRetailPriceTextField

    /**
     * Gets the quantity text field of this add view.
     *
     * @return the quantity text field of this add view
     */
    public JTextField getQuantityTextField() {
        return this.quantityTextField;
    } //getQuantityTextField

    /**
     * Gets the add button of this add view.
     *
     * @return the add button of this add view
     */
    public JButton getAddButton() {
        return this.addButton;
    } //getAddButton

    /**
     * Gets the clear button of this add view.
     *
     * @return the clear button of this add view
     */
    public JButton getClearButton() {
        return this.clearButton;
    } //getClearButton

    /**
     * Gets the hash code of this add view.
     *
     * @return the hash code of this add view
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.mainPanel == null ? 0 : this.mainPanel.hashCode());

        result = 19 * result + (this.skuTextField == null ? 0 : this.skuTextField.hashCode());

        result = 19 * result + (this.nameTextField == null ? 0 : this.nameTextField.hashCode());

        result = 19 * result + (this.wholesalePriceTextField == null ? 0 : this.wholesalePriceTextField.hashCode());

        result = 19 * result + (this.retailPriceTextField == null ? 0 : this.retailPriceTextField.hashCode());

        result = 19 * result + (this.quantityTextField == null ? 0 : this.quantityTextField.hashCode());

        result = 19 * result + (this.addButton == null ? 0 : this.addButton.hashCode());

        result = 19 * result + (this.clearButton == null ? 0 : this.clearButton.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this add view is equal to the specified object. {@code true} is returned if and
     * only if the specified object is an instance of {@code AddView}, and its field values are equal to this
     * add view's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this add view is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof AddView)
                && (this.mainPanel == null ? ((AddView) anObject).mainPanel == null : this.mainPanel.equals(((AddView) anObject).mainPanel))
                && (this.skuTextField == null ? ((AddView) anObject).skuTextField == null : this.skuTextField.equals(((AddView) anObject).skuTextField))
                && (this.nameTextField == null ? ((AddView) anObject).nameTextField == null : this.nameTextField.equals(((AddView) anObject).nameTextField))
                && (this.wholesalePriceTextField == null ? ((AddView) anObject).wholesalePriceTextField == null : this.wholesalePriceTextField.equals(((AddView) anObject).wholesalePriceTextField))
                && (this.retailPriceTextField == null ? ((AddView) anObject).retailPriceTextField == null : this.retailPriceTextField.equals(((AddView) anObject).retailPriceTextField))
                && (this.quantityTextField == null ? ((AddView) anObject).quantityTextField == null : this.quantityTextField.equals(((AddView) anObject).quantityTextField))
                && (this.addButton == null ? ((AddView) anObject).addButton == null : this.addButton.equals(((AddView) anObject).addButton))
                && (this.clearButton == null ? ((AddView) anObject).clearButton == null : this.clearButton.equals(((AddView) anObject).clearButton));
    } //equals

    /**
     * Gets a {@code String} representation of this add view.
     *
     * @return a {@code String} representation of this add view
     */
    @Override
    public String toString() {
        return String.format("AddView[%s, %s, %s, %s, %s, %s, %s, %s]", this.mainPanel, this.skuTextField, this.nameTextField, this.wholesalePriceTextField, this.retailPriceTextField, this.quantityTextField, this.addButton, this.clearButton);
    } //toString
}