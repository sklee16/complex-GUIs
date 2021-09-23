import javax.swing.*;
import java.util.Optional;

/**
 * An update controller of a product inventory application.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class UpdateController {
    /**
     * The inventory model of this update controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The update view of this update controller.
     */
    private UpdateView updateView;

    /**
     * Constructs a newly allocated {@code UpdateController} object with the specified inventory model and update view.
     *
     * @param inventoryModel the inventory model of this update controller
     * @param updateView     the update view of this update controller
     * @throws IllegalArgumentException if the {@code inventoryModel} argument or {@code updateView} argument is
     *                                  {@code null}
     */
    public UpdateController(InventoryModel inventoryModel, UpdateView updateView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("inventoryModel argument is null");
        } else if (updateView == null) {
            throw new IllegalArgumentException("updateView argument is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.updateView = updateView;

            this.updateView.getUpdateButton().addActionListener(e -> this.getUpdateButtonSemantics());

            this.updateView.getClearButton().addActionListener(e -> this.getClearButtonSemantics());
        } //end if
    } //UpdateController

    /**
     * Gets the semantics of an update view's update button.
     */
    private void getUpdateButtonSemantics() {
        //TODO implement method
        Optional<Product> sku = inventoryModel.searchBySku(updateView.getSkuTextField().getText());

        if (!sku.isPresent()) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "A Product with the specified SKU does not exist in this inventory!",
                    "Product Inventory", JOptionPane.ERROR_MESSAGE);
            updateView.getSkuTextField().requestFocus();

        } else {
            if (updateView.getFieldComboBox().getSelectedIndex()==-1) {
                JOptionPane.showMessageDialog(new JFrame(), "Please select the option available in the field!",
                        "Product Inventory", JOptionPane.ERROR_MESSAGE);
                updateView.getFieldComboBox().requestFocus();
            } else {
                if (updateView.getFieldComboBox().getSelectedItem().equals("SKU")) {
                    if (inventoryModel.searchBySku(updateView.getNewFieldValueTextField().getText()).isPresent()) {
                        JOptionPane.showMessageDialog(new JFrame(),
                                "This product's SKU could not be updated!\nA Product with the specified SKU already exists!",
                                "Product Inventory", JOptionPane.ERROR_MESSAGE);
                        updateView.getNewFieldValueTextField().requestFocus();
                    } else {
                        sku.get().setSku(updateView.getNewFieldValueTextField().getText());
                        JOptionPane.showMessageDialog(new JFrame(),
                                "This product's sku has been updated from the inventory.",
                                "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                        updateView.getSkuTextField().setText("");
                        updateView.getFieldComboBox().setSelectedIndex(-1);
                        updateView.getNewFieldValueTextField().setText("");
                        updateView.getSkuTextField().requestFocus();
                    }
                } else if (updateView.getFieldComboBox().getSelectedItem().equals("Name")) {
                    if (updateView.getNewFieldValueTextField().getText().equals("")) {
                        JOptionPane.showMessageDialog(new JFrame(),
                                "This product's name could not be updated!\nThe specified name is invalid!",
                                "Product Inventory", JOptionPane.ERROR_MESSAGE);
                        updateView.getNewFieldValueTextField().requestFocus();
                    } else {
                        sku.get().setName(updateView.getNewFieldValueTextField().getText());
                        JOptionPane.showMessageDialog(new JFrame(),
                                "This product's name has been updated from the inventory.",
                                "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                        updateView.getSkuTextField().setText("");
                        updateView.getNewFieldValueTextField().setText("");
                        updateView.getFieldComboBox().setSelectedIndex(-1);
                        updateView.getSkuTextField().requestFocus();
                    }
                } else if (updateView.getFieldComboBox().getSelectedItem().equals("Wholesale price")) {
                    try {
                        if (Double.parseDouble(updateView.getNewFieldValueTextField().getText())<0) {
                                JOptionPane.showMessageDialog(new JFrame(), "The product's wholesale price could not be updated!\n" +
                                        "The specified wholesale price is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                                updateView.getNewFieldValueTextField().requestFocus();
                        } else{
                            sku.get().setWholesalePrice(Double.parseDouble(updateView.getNewFieldValueTextField().getText()));
                            JOptionPane.showMessageDialog(new JFrame(),
                                    "This product's wholesale price has been updated from the inventory.",
                                    "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                            updateView.getSkuTextField().setText("");
                            updateView.getFieldComboBox().setSelectedIndex(-1);
                            updateView.getNewFieldValueTextField().setText("");
                            updateView.getSkuTextField().requestFocus();
                        }

                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(new JFrame(),
                                "This product's wholesale price could not be updated!\n" +
                                        "The specified wholesale price is not a vaild number!",
                                "Product Inventory", JOptionPane.ERROR_MESSAGE);
                        updateView.getNewFieldValueTextField().requestFocus();
                    }
                } else if (updateView.getFieldComboBox().getSelectedItem().equals("Retail price")) {
                    try {
                        if (Double.parseDouble(updateView.getNewFieldValueTextField().getText())<0) {
                            JOptionPane.showMessageDialog(new JFrame(), "The product's retail price could not be updated!\n" +
                                    "The specified retail price is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                            updateView.getNewFieldValueTextField().requestFocus();
                        } else {
                            sku.get().setRetailPrice(Double.parseDouble(updateView.getNewFieldValueTextField().getText()));
                            JOptionPane.showMessageDialog(new JFrame(),
                                    "This product's retail price has been updated from the inventory.",
                                    "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                            updateView.getSkuTextField().setText("");
                            updateView.getFieldComboBox().setSelectedIndex(-1);
                            updateView.getNewFieldValueTextField().setText("");
                            updateView.getSkuTextField().requestFocus();
                        }

                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(new JFrame(),
                                "This product's retail price could not be updated!\n" +
                                        "The specified retail price is not a vaild number!",
                                "Product Inventory", JOptionPane.ERROR_MESSAGE);
                        updateView.getNewFieldValueTextField().requestFocus();
                    }
                } else if (updateView.getFieldComboBox().getSelectedItem().equals("Quantity")) {
                    try {
                        if (Double.parseDouble(updateView.getNewFieldValueTextField().getText())<0) {
                            JOptionPane.showMessageDialog(new JFrame(), "The specified quantity is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                            updateView.getNewFieldValueTextField().requestFocus();
                        } else {
                            sku.get().setQuantity(Integer.parseInt(updateView.getNewFieldValueTextField().getText()));
                            JOptionPane.showMessageDialog(new JFrame(),
                                    "This product's quantity has been updated from the inventory.",
                                    "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                            updateView.getSkuTextField().setText("");
                            updateView.getFieldComboBox().setSelectedIndex(-1);
                            updateView.getNewFieldValueTextField().setText("");
                            updateView.getSkuTextField().requestFocus();
                        }
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(new JFrame(),
                                "This product's quantity could not be updated!\n" +
                                        "The specified quantity is not a vaild number!",
                                "Product Inventory", JOptionPane.ERROR_MESSAGE);
                        updateView.getNewFieldValueTextField().requestFocus();
                    }
                }
            }
        }

    } //getUpdateButtonSemantics

    /**
     * Gets the semantics of an update view's clear button.
     */
    private void getClearButtonSemantics() {
        //TODO implement method
        updateView.getSkuTextField().setText("");
        updateView.getFieldComboBox().setSelectedIndex(-1);
        updateView.getNewFieldValueTextField().setText("");
        updateView.getSkuTextField().requestFocus();

    } //getClearButtonSemantics

    /**
     * Gets the hash code of this update controller.
     *
     * @return the hash code of this update controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.inventoryModel == null ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + (this.updateView == null ? 0 : this.updateView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this update controller is equal to the specified object. {@code true} is returned if
     * and only if the specified object is an instance of {@code UpdateController}, and its field values are equal to
     * this update controller's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this update controller is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof UpdateController)
                && (this.inventoryModel == null ? ((UpdateController) anObject).inventoryModel == null : this.inventoryModel.equals(((UpdateController) anObject).inventoryModel))
                && (this.updateView == null ? ((UpdateController) anObject).updateView == null : this.updateView.equals(((UpdateController) anObject).updateView));
    } //equals

    /**
     * Gets a {@code String} representation of this update controller.
     *
     * @return a {@code String} representation of this update controller
     */
    @Override
    public String toString() {
        return String.format("UpdateController[%s, %s]", this.inventoryModel, this.updateView);
    } //toString
}