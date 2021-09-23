import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * A remove view of a product inventory application.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class RemoveView {
    /**
     * The main panel of this remove view.
     */
    private JPanel mainPanel;

    /**
     * The SKU text field of this remove view.
     */
    private JTextField skuTextField;

    /**
     * The remove button of this remove view.
     */
    private JButton removeButton;

    /**
     * The clear button of this remove view.
     */
    private JButton clearButton;

    /**
     * Constructs a newly allocated {@code RemoveView} object.
     */
    public RemoveView() {
        //
    } //RemoveView

    /**
     * Gets the main panel of this remove view.
     *
     * @return the main panel of this remove view
     */
    public JPanel getMainPanel() {
        return this.mainPanel;
    } //getMainPanel

    /**
     * Gets the SKU text field of this remove view.
     *
     * @return the SKU text field of this remove view
     */
    public JTextField getSkuTextField() {
        return this.skuTextField;
    } //getSkuTextField

    /**
     * Gets the remove button of this remove view.
     *
     * @return the remove button of this remove view
     */
    public JButton getRemoveButton() {
        return this.removeButton;
    } //getRemoveButton

    /**
     * Gets the clear button of this remove view.
     *
     * @return the clear button of this remove view
     */
    public JButton getClearButton() {
        return this.clearButton;
    } //getClearButton

    /**
     * Gets the hash code of this remove view.
     *
     * @return the hash code of this remove view
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.mainPanel == null ? 0 : this.mainPanel.hashCode());

        result = 19 * result + (this.skuTextField == null ? 0 : this.skuTextField.hashCode());

        result = 19 * result + (this.removeButton == null ? 0 : this.removeButton.hashCode());

        result = 19 * result + (this.clearButton == null ? 0 : this.clearButton.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this remove view is equal to the specified object. {@code true} is returned if and
     * only if the specified object is an instance of {@code RemoveView}, and its field values are equal to this
     * remove view's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this remove view is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof RemoveView)
                && (this.mainPanel == null ? ((RemoveView) anObject).mainPanel == null : this.mainPanel.equals(((RemoveView) anObject).mainPanel))
                && (this.skuTextField == null ? ((RemoveView) anObject).skuTextField == null : this.skuTextField.equals(((RemoveView) anObject).skuTextField))
                && (this.removeButton == null ? ((RemoveView) anObject).removeButton == null : this.removeButton.equals(((RemoveView) anObject).removeButton))
                && (this.clearButton == null ? ((RemoveView) anObject).clearButton == null : this.clearButton.equals(((RemoveView) anObject).clearButton));
    } //equals

    /**
     * Gets a {@code String} representation of this remove view.
     *
     * @return a {@code String} representation of this remove view
     */
    @Override
    public String toString() {
        return String.format("RemoveView[%s, %s, %s, %s]", this.mainPanel, this.skuTextField, this.removeButton, this.clearButton);
    } //toString
}