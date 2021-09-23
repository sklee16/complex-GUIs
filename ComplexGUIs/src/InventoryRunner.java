import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;

/**
 * A runner of a product inventory application.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class InventoryRunner {
    /**
     * Runs the product inventory application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();

            return;
        } //end try catch

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Product Inventory");
            InventoryModel inventoryModel = new InventoryModel();
            InventoryView inventoryView = new InventoryView();

            new AddController(inventoryModel, inventoryView.getAddView());

            new UpdateController(inventoryModel, inventoryView.getUpdateView());

            new RemoveController(inventoryModel, inventoryView.getRemoveView());

            new SearchController(inventoryModel, inventoryView.getSearchView());

            frame.setContentPane(inventoryView.getMainPanel());

            frame.pack();

            frame.setLocationRelativeTo(null);

            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            frame.setVisible(true);
        });
    } //main
}