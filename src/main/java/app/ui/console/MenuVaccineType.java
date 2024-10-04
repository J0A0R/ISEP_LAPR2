package app.ui.console;

import org.apache.commons.lang3.StringUtils;
import java.util.Objects;

/**
 * The vaccine type Menu.
 */
public class MenuVaccineType {

    private String description;
    private Runnable ui;

    public MenuVaccineType(String description,  Runnable ui)
    {
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException("Menu description cannot be null or empty.");
        if (Objects.isNull(ui))
            throw new IllegalArgumentException("Menu does not support a null UI.");

        this.description = description;
        this.ui = ui;
    }

    public void run() {
        this.ui.run();
    }

    @Override
    public String toString()
    {
        return this.description;
    }
}
