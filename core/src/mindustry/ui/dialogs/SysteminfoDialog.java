package mindustry.ui.dialogs;

import arc.*;
import arc.graphics.*;
import arc.input.KeyCode;
import arc.scene.event.*;
import arc.scene.ui.*;
import arc.scene.ui.layout.*;
import arc.struct.*;
import arc.util.*;
import com.sun.management.OperatingSystemMXBean;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.ui.*;

import com.sun.management.*;
import java.lang.management.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import static arc.Core.bundle;
import static mindustry.Vars.ui;

public class SysteminfoDialog extends Dialog{
    public SettingsMenuDialog.SettingsTable graphics;
    public SettingsMenuDialog.SettingsTable game;
    public SettingsMenuDialog.SettingsTable sound;
    public SettingsMenuDialog.SettingsTable main;

    private Table prefs;
    private Table menu;
    private BaseDialog Systeminfo;
    private Seq<SettingsMenuDialog.SettingsCategory> categories = new Seq<>();



    //detects what os and architecture it is
    private String osget = System.getProperty("os.name") + " v" + System.getProperty("os.version") + " " + System.getProperty("os.arch");
    //ram usage
    private long ram = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    //total ram
    private long totalram = Runtime.getRuntime().totalMemory();


    public static String humanReadableByteCountSI(long bytes) {
        if (-1000 < bytes && bytes < 1000) {
            return bytes + " B";
        }
        CharacterIterator ci = new StringCharacterIterator("kMGTPE");
        while (bytes <= -999_950 || bytes >= 999_950) {
            bytes /= 1000;
            ci.next();
        }
        return String.format("%.1f %cB", bytes / 1000.0, ci.current());
    }

    public SysteminfoDialog(){
        super(bundle.get("systeminfo", "System Information"));
        Systeminfo = new BaseDialog(bundle.get("settings.systeminfo", "System Information"));
        Systeminfo.setFillParent(true);

        cont.table(t -> {
            t.margin(10f);
            t.pane(p -> {
                p.margin(10f);

                p.table(info -> {
                    //os
                    info.add(bundle.get("os", "OS:\n")+ osget).left();
                    //ram usage with percentage and progressbar
                    info.row();
                    info.add("RAM:\nTotal:" +humanReadableByteCountSI(totalram)+ "\nUsage:" +humanReadableByteCountSI(ram)).left();
                    info.row();
                    //java vendor and version
                    info.add(bundle.get("java", "Java:\n")+ System.getProperty("java.vendor") + " Java " + System.getProperty("java.version")).left();

                });

            });
            t.button(Icon.left, this::hide).center();
        });

    }
}
