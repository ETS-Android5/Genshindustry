package mindustry.mod;

/** Mod listing as a data class. */
public class ModListing{
    public String repo, name, author, lastUpdated, description, minGameVersion, branch;
    public boolean hasScripts, hasJava;
    public String[] contentTypes = {};
    public int stars;

    @Override
    public String toString(){
        return "ModListing{" +
        "repo='" + repo + '\'' +
        ", name='" + name + '\'' +
        ", author='" + author + '\'' +
        ", lastUpdated='" + lastUpdated + '\'' +
        ", description='" + description + '\'' +
        ", minGameVersion='" + minGameVersion + '\'' +
        ", hasScripts=" + hasScripts +
        ", hasJava=" + hasJava +
        ", branch=" + branch +
        ", stars=" + stars +
        '}';
    }
}
