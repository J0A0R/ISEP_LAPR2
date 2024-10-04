package app.ui.console.Menu;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class MenuImport {
    /**
     * Description of line
     */
    private String description;

    /**
     * Interface Runnable
     */
    private Runnable ui;

    /**
     * Instantiates a new Menu imports.
     *
     * @param description the description of line
     * @param ui interface Runnable
     */
    public MenuImport(String description, Runnable ui)
    {
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException("Menu description cannot be null or empty.");
        if (Objects.isNull(ui))
            throw new IllegalArgumentException("Menu does not support a null UI.");

        this.description = description;
        this.ui = ui;
    }

    /**
     * Run.
     */
    public void run() {
        this.ui.run();
    }

    /**
     * Returns the textual description of the menu.
     * @return menu description
     */
    @Override
    public String toString()
    {
        return this.description;
    }
}