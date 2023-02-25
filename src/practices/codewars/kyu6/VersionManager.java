package practices.codewars.kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VersionManager {

  private static final String INITIAL_VERSION = "0.0.1";
  private final List<String> versionHistory = new ArrayList<>();
  private int majorParam;
  private int minorParam;
  private int patchParam;

  public VersionManager() {
    setParameters(INITIAL_VERSION);
    addToVersionHistory();
  }

  public VersionManager(String version) {
    setParameters(version);
    addToVersionHistory();
  }

  private void addToVersionHistory(){
    this.versionHistory.add(this.release());
  }

  private void setParameters(String version){
    if (version==null || "".equals(version)){
      setParameters(INITIAL_VERSION);
    } else {
      List<String> params = Arrays.stream(version.split("\\."))
          .limit(3)
          .collect(Collectors.toList());
      for (String param: params) {
        if (!param.matches("[0-9]+")){
          throw new IllegalArgumentException("Error occured while parsing version!");
        }
      }
      params.add("0");
      params.add("0");
      setParameters(Integer.parseInt(params.get(0)), Integer.parseInt(params.get(1)), Integer.parseInt(params.get(2)));
    }
  }

  private void setParameters(int majorParam, int minorParam, int patchParam){
    this.majorParam = majorParam;
    this.minorParam = minorParam;
    this.patchParam = patchParam;
  }

  public VersionManager major(){
    setParameters(this.majorParam+1,0,0);
    addToVersionHistory();
    return this;
  }

  public VersionManager minor(){
    setParameters(this.majorParam, this.minorParam+1, 0);
    addToVersionHistory();
    return this;
  }

  public VersionManager patch(){
    setParameters(this.majorParam, this.minorParam, this.patchParam+1);
    addToVersionHistory();
    return this;
  }

  public VersionManager rollback() throws Exception {
    int versionHistorySize = this.versionHistory.size();
    if (versionHistorySize==1){
      throw new Exception("Cannot rollback!");
    }
    this.versionHistory.remove(versionHistorySize-1);
    setParameters(this.versionHistory.get(versionHistorySize-2));
    return this;
  }

  public String release(){
    return String.format("%s.%s.%s", this.majorParam, this.minorParam, this.patchParam);
  }
}
