package app.ui.console;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class MenuEmployee {
    private String description;
    private Runnable ui;

    public MenuEmployee(String description, Runnable ui)
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
