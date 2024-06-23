
package no.priv.garshol.duke.cleaners;

import no.priv.garshol.duke.Cleaner;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for building regular-expression based cleaners.
 */
public abstract class AbstractRuleBasedCleaner implements Cleaner {
  private List<Transform> transforms;

  /**
   * Initializes an empty cleaner.
   */
  public AbstractRuleBasedCleaner() {
    this.transforms = new ArrayList();
  }

  public String clean(String value) {
    // perform pre-registered transforms
    for (Transform t : transforms)
      value = t.transform(value);
    
    return value;
  }

  /**
   * Adds a rule replacing all substrings matching the regular
   * expression with the replacement string.
   */
  public void add(String regex, String replacement) {
    add(regex, replacement, 1);
  }

  /**
   * Adds a rule replacing all substrings matching the specified group
   * within the regular expression with the replacement string.
   */
  public void add(String regex, String replacement, int groupno) {
    transforms.add(new Transform(regex, replacement, groupno));
  }
}