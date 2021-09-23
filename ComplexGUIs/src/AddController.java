import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An add controller of a product inventory application.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class AddController {
    /**
     * The inventory model of this add controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The add view of this add controller.
     */
    private AddView addView;

    /**
     * Constructs a newly allocated {@code AddController} object with the specified inventory model and add view.
     *
     * @param inventoryModel the inventory model of this add controller
     * @param addView        the add view of this add controller
     * @throws IllegalArgumentException if the {@code inventoryModel} argument or {@code addView} argument is
     *                                  {@code null}
     */
    public AddController(InventoryModel inventoryModel, AddView addView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("inventoryModel argument is null");
        } else if (addView == null) {
            throw new IllegalArgumentException("addView argument is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.addView = addView;

            this.addView.getAddButton().addActionListener(e -> this.getAddButtonSemantics());

            this.addView.getClearButton().addActionListener(e -> this.getClearButtonSemantics());
        } //end if
    } //AddController

    /**
     * Gets the semantics of an add view's add button.
     */
    private void getAddButtonSemantics() {
        //TODO implement method
                boolean name=true;
                boolean wholesaleprice = true;
                boolean retailprice = true;
                boolean quantity = true;

                if (inventoryModel.searchBySku(addView.getSkuTextField().getText()).isPresent()) {
                    JOptionPane.showMessageDialog(new JFrame(),
                            "This product could not be added to the inventory!\nA Product with the specified SKU already exists!",
                            "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    addView.getSkuTextField().requestFocusInWindow();
                } else {
                    if (addView.getNameTextField().getText().equals("")) {
                        name=false;
                        JOptionPane.showMessageDialog(new JFrame(), "The specified name is not valid!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                        addView.getNameTextField().requestFocus();
                    }

                    if(name) {

                        try {
                            Double.parseDouble(addView.getWholesalePriceTextField().getText());
                            if (Double.parseDouble(addView.getWholesalePriceTextField().getText()) < 0) {
                                JOptionPane.showMessageDialog(new JFrame(), "The specified wholesale price is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                                addView.getWholesalePriceTextField().requestFocus();
                                wholesaleprice = false;
                            }
                        } catch (NumberFormatException nfe) {
                            JOptionPane.showMessageDialog(new JFrame(), "The specified wholesale price is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                            addView.getWholesalePriceTextField().requestFocus();
                            wholesaleprice = false;
                        }
                    }

                    if (name && wholesaleprice) {
                        try {
                            Double.parseDouble(addView.getRetailPriceTextField().getText());
                            if (Double.parseDouble(addView.getRetailPriceTextField().getText())<0) {
                                JOptionPane.showMessageDialog(new JFrame(), "The specified retail price is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                                addView.getWholesalePriceTextField().requestFocus();
                                wholesaleprice = false;
                            }
                        } catch (NumberFormatException nfe) {
                            JOptionPane.showMessageDialog(new JFrame(), "The specified retail price is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                            addView.getRetailPriceTextField().requestFocus();
                            retailprice = false;
                        }
                    }

                    if (name && wholesaleprice && retailprice) {
                        try {
                            Integer.parseInt(addView.getQuantityTextField().getText());
                            if (Integer.parseInt(addView.getQuantityTextField().getText())<0) {
                                JOptionPane.showMessageDialog(new JFrame(), "The specified quantity is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                                addView.getWholesalePriceTextField().requestFocus();
                                wholesaleprice = false;
                            }
                        } catch (NumberFormatException nfe) {
                            JOptionPane.showMessageDialog(new JFrame(), "The specified quantity is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                            addView.getQuantityTextField().requestFocus();
                            quantity = false;
                        }
                    }


                    if (name && wholesaleprice && retailprice && quantity) {
                        Product product = new Product(addView.getSkuTextField().getText(),
                                addView.getNameTextField().getText(),
                                Double.parseDouble(addView.getWholesalePriceTextField().getText()),
                                Double.parseDouble(addView.getRetailPriceTextField().getText()),
                                Integer.parseInt(addView.getQuantityTextField().getText()));
                        inventoryModel.add(product);
                        JOptionPane.showMessageDialog(new JFrame(), "This product has been added to the inventory", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                        addView.getNameTextField().setText("");
                        addView.getSkuTextField().setText("");
                        addView.getWholesalePriceTextField().setText("");
                        addView.getRetailPriceTextField().setText("");
                        addView.getQuantityTextField().setText("");
                        addView.getSkuTextField().requestFocus();
                    }
                }

    } //getAddButtonSemantics

    /**
     * Gets the semantics of an add view's clear button.
     */
    private void getClearButtonSemantics() {
        //TODO implement method
                addView.getNameTextField().setText("");
                addView.getSkuTextField().setText("");
                addView.getWholesalePriceTextField().setText("");
                addView.getRetailPriceTextField().setText("");
                addView.getQuantityTextField().setText("");
                addView.getSkuTextField().requestFocus();


    } //getClearButtonSemantics

    /**
     * Gets the hash code of this add controller.
     *
     * @return the hash code of this add controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.inventoryModel == null ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + (this.addView == null ? 0 : this.addView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this add controller is equal to the specified object. {@code true} is returned if and
     * only if the specified object is an instance of {@code AddController}, and its field values are equal to this
     * add controller's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this add controller is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof AddController)
                && (this.inventoryModel == null ? ((AddController) anObject).inventoryModel == null : this.inventoryModel.equals(((AddController) anObject).inventoryModel))
                && (this.addView == null ? ((AddController) anObject).addView == null : this.addView.equals(((AddController) anObject).addView));
    } //equals

    /**
     * Gets a {@code String} representation of this add controller.
     *
     * @return a {@code String} representation of this add controller
     */
    @Override
    public String toString() {
        return String.format("AddController[%s, %s]", this.inventoryModel, this.addView);
    } //toString
}