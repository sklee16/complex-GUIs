import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

/**
 * A search view of a product inventory application.
 *
 * <p>CS18000 -- Spring 2018 -- Complex GUIs -- Homework</p>
 */
public final class SearchView {
    /**
     * The main panel of this search view.
     */
    private JPanel mainPanel;

    /**
     * The field combo box of this search view.
     */
    private JComboBox<String> fieldComboBox;

    /**
     * The search value text field of this search view.
     */
    private JTextField searchValueTextField;

    /**
     * The results text area of this search view.
     */
    private JTextArea resultsTextArea;

    /**
     * The search button of this search view.
     */
    private JButton searchButton;

    /**
     * The clear button of this search view.
     */
    private JButton clearButton;

    /**
     * Constructs a newly allocated {@code SearchView} object.
     */
    public SearchView() {
        this.fieldComboBox.setSelectedIndex(-1);

        this.resultsTextArea.setPreferredSize(null);
    } //SearchView

    /**
     * Gets the main panel of this search view.
     *
     * @return the main panel of this search view
     */
    public JPanel getMainPanel() {
        return this.mainPanel;
    } //getMainPanel

    /**
     * Gets the field combo box of this search view.
     *
     * @return the field combo box of this search view
     */
    public JComboBox<String> getFieldComboBox() {
        return this.fieldComboBox;
    } //getFieldComboBox

    /**
     * Gets the search value text field of this search view.
     *
     * @return the search value text field of this search view
     */
    public JTextField getSearchValueTextField() {
        return this.searchValueTextField;
    } //getSearchValueTextField

    /**
     * Gets the results text pane of this search view.
     *
     * @return the results text pane of this search view
     */
    public JTextArea getResultsTextArea() {
        return this.resultsTextArea;
    } //getResultsTextArea

    /**
     * Gets the search button of this search view.
     *
     * @return the search button of this search view
     */
    public JButton getSearchButton() {
        return this.searchButton;
    } //getSearchButton

    /**
     * Gets the clear button of this search view.
     *
     * @return the clear button of this search view
     */
    public JButton getClearButton() {
        return this.clearButton;
    } //getClearButton

    /**
     * Gets the hash code of this search view.
     *
     * @return the hash code of this search view
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.mainPanel == null ? 0 : this.mainPanel.hashCode());

        result = 19 * result + (this.fieldComboBox == null ? 0 : this.fieldComboBox.hashCode());

        result = 19 * result + (this.searchValueTextField == null ? 0 : this.searchValueTextField.hashCode());

        result = 19 * result + (this.resultsTextArea == null ? 0 : this.resultsTextArea.hashCode());

        result = 19 * result + (this.searchButton == null ? 0 : this.searchButton.hashCode());

        result = 19 * result + (this.clearButton == null ? 0 : this.clearButton.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this search view is equal to the specified object. {@code true} is returned if and
     * only if the specified object is an instance of {@code SearchView}, and its field values are equal to this
     * search view's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this search view is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof SearchView)
                && (this.mainPanel == null ? ((SearchView) anObject).mainPanel == null : this.mainPanel.equals(((SearchView) anObject).mainPanel))
                && (this.fieldComboBox == null ? ((SearchView) anObject).fieldComboBox == null : this.fieldComboBox.equals(((SearchView) anObject).fieldComboBox))
                && (this.searchValueTextField == null ? ((SearchView) anObject).searchValueTextField == null : this.searchValueTextField.equals(((SearchView) anObject).searchValueTextField))
                && (this.resultsTextArea == null ? ((SearchView) anObject).resultsTextArea == null : this.resultsTextArea.equals(((SearchView) anObject).resultsTextArea))
                && (this.searchButton == null ? ((SearchView) anObject).searchButton == null : this.searchButton.equals(((SearchView) anObject).searchButton))
                && (this.clearButton == null ? ((SearchView) anObject).clearButton == null : this.clearButton.equals(((SearchView) anObject).clearButton));
    } //equals

    /**
     * Gets a {@code String} representation of this search view.
     *
     * @return a {@code String} representation of this search view
     */
    @Override
    public String toString() {
        return String.format("RemoveView[%s, %s, %s, %s, %s, %s]", this.mainPanel, this.fieldComboBox, this.searchValueTextField, this.resultsTextArea, this.searchButton, this.clearButton);
    } //toString
}