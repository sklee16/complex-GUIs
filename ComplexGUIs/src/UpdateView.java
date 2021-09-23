import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

/**
 * An update view of a product inventory application.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class UpdateView {
    /**
     * The main panel of this update view.
     */
    private JPanel mainPanel;

    /**
     * The SKU text field of this update view.
     */
    private JTextField skuTextField;
    
    /**
     * The field combo box of this update view.
     */
    private JComboBox<String> fieldComboBox;

    /**
     * The new field value text field of this update view.
     */
    private JTextField newFieldValueTextField;

    /**
     * The update button of this update view.
     */
    private JButton updateButton;

    /**
     * The clear button of this update view.
     */
    private JButton clearButton;

    /**
     * Constructs a newly allocated {@code UpdateView} object.
     */
    public UpdateView() {
        this.fieldComboBox.setSelectedIndex(-1);
    } //UpdateView

    /**
     * Gets the main panel of this update view.
     *
     * @return the main panel of this update view
     */
    public JPanel getMainPanel() {
        return this.mainPanel;
    } //getMainPanel

    /**
     * Gets the SKU text field of this update view.
     *
     * @return the SKU text field of this update view
     */
    public JTextField getSkuTextField() {
        return this.skuTextField;
    } //getSkuTextField

    /**
     * Gets the field combo box of this update view.
     *
     * @return the field combo box of this update view
     */
    public JComboBox<String> getFieldComboBox() {
        return this.fieldComboBox;
    } //getFieldComboBox

    /**
     * Gets the new field value text field of this update view.
     *
     * @return the new field value text field of this update view
     */
    public JTextField getNewFieldValueTextField() {
        return this.newFieldValueTextField;
    } //getNewFieldValueTextField

    /**
     * Gets the update button of this update view.
     *
     * @return the update button of this update view
     */
    public JButton getUpdateButton() {
        return this.updateButton;
    } //getUpdateButton

    /**
     * Gets the clear button of this update view.
     *
     * @return the clear button of this update view
     */
    public JButton getClearButton() {
        return this.clearButton;
    } //getClearButton

    /**
     * Gets the hash code of this update view.
     *
     * @return the hash code of this update view
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.mainPanel == null ? 0 : this.mainPanel.hashCode());

        result = 19 * result + (this.skuTextField == null ? 0 : this.skuTextField.hashCode());

        result = 19 * result + (this.fieldComboBox == null ? 0 : this.fieldComboBox.hashCode());

        result = 19 * result + (this.newFieldValueTextField == null ? 0 : this.newFieldValueTextField.hashCode());

        result = 19 * result + (this.updateButton == null ? 0 : this.updateButton.hashCode());

        result = 19 * result + (this.clearButton == null ? 0 : this.clearButton.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this update view is equal to the specified object. {@code true} is returned if and
     * only if the specified object is an instance of {@code UpdateView}, and its field values are equal to this
     * update view's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this update view is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof UpdateView)
                && (this.mainPanel == null ? ((UpdateView) anObject).mainPanel == null : this.mainPanel.equals(((UpdateView) anObject).mainPanel))
                && (this.skuTextField == null ? ((UpdateView) anObject).skuTextField == null : this.skuTextField.equals(((UpdateView) anObject).skuTextField))
                && (this.fieldComboBox == null ? ((UpdateView) anObject).fieldComboBox == null : this.fieldComboBox.equals(((UpdateView) anObject).fieldComboBox))
                && (this.newFieldValueTextField == null ? ((UpdateView) anObject).newFieldValueTextField == null : this.newFieldValueTextField.equals(((UpdateView) anObject).newFieldValueTextField))
                && (this.updateButton == null ? ((UpdateView) anObject).updateButton == null : this.updateButton.equals(((UpdateView) anObject).updateButton))
                && (this.clearButton == null ? ((UpdateView) anObject).clearButton == null : this.clearButton.equals(((UpdateView) anObject).clearButton));
    } //equals

    /**
     * Gets a {@code String} representation of this update view.
     *
     * @return a {@code String} representation of this update view
     */
    @Override
    public String toString() {
        return String.format("UpdateView[%s, %s, %s, %s, %s, %s]", this.mainPanel, this.skuTextField, this.fieldComboBox, this.newFieldValueTextField, this.updateButton, this.clearButton);
    } //toString
}