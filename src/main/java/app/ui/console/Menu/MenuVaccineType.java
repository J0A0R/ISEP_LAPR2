package app.ui.console.Menu;

import app.ui.console.NewVaccineTypeUI;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class MenuVaccineType {

    /**
     * Description of line
     */
    private String description;

    /**
     * Interface Runnable
     */
    private Runnable ui;

    private NewVaccineTypeUI VTUI;

    /**
     * Instantiates a new Menu employee.
     *
     * @param description the description of line
     * @param ui interface Runnable
     */
    public MenuVaccineType(String description,  Runnable ui)
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
