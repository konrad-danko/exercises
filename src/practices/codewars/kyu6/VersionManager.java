package practices.codewars.kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VersionManager {

  private final List<String> versionHistory = new ArrayList<>();
  private static final String INITIAL_VERSION = "0.0.1";
  private int majorParam;
  private int minorParam;
  private int patchParam;

  public VersionManager() {
    setParameters(INITIAL_VERSION);
    this.versionHistory.add(this.release());
  }

  public VersionManager(String version) {
    setParameters(version);
    this.versionHistory.add(this.release());
  }

  private void setParameters(String version){
    if (version==null || "".equals(version)){
      setParameters(INITIAL_VERSION);
    } else {
      List<String> params = Arrays.stream(version.split("\\."))
          .limit(3)
          .collect(Collectors.toList());
      if (params.size() != params.stream()
          .map(s-> s.matches("[0-9]+"))
          .filter(d-> d)
          .count()){
        throw new IllegalArgumentException("Error occured while parsing version!");
      }
      params.add("0");
      params.add("0");
      this.majorParam = Integer.parseInt(params.get(0));
      this.minorParam = Integer.parseInt(params.get(1));
      this.patchParam = Integer.parseInt(params.get(2));
    }
  }

  public VersionManager major(){
    this.majorParam++;
    this.minorParam = 0;
    this.patchParam = 0;
    this.versionHistory.add(this.release());
    return this;
  }

  public VersionManager minor(){
    this.minorParam++;
    this.patchParam = 0;
    this.versionHistory.add(this.release());
    return this;
  }

  public VersionManager patch(){
    this.patchParam++;
    this.versionHistory.add(this.release());
    return this;
  }

  public VersionManager rollback() throws Exception {
    int versionHistorySize = this.versionHistory.size();
    if (versionHistorySize==1){
      throw new Exception("Cannot rollback!");
    }
    this.versionHistory.remove(versionHistorySize-1);
    setParameters(this.versionHistory.get(versionHistorySize - 2));
    return this;
  }

  public String release(){
    return String.format("%s.%s.%s", this.majorParam, this.minorParam, this.patchParam);
  }
}
