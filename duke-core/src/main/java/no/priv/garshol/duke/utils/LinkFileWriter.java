
package no.priv.garshol.duke.utils;

import no.priv.garshol.duke.Configuration;
import no.priv.garshol.duke.DukeException;
import no.priv.garshol.duke.Property;
import no.priv.garshol.duke.Record;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

/**
 * Utility class for writing link files. The format is
 * _,id,id,confidence, where the first character is either '+' or '-'.
 * @since 1.1
 */
public class LinkFileWriter {
  private Writer out;
  private Collection<Property> idprops;

  public LinkFileWriter(Writer out) {
    this(out, null);
  }
  
  public LinkFileWriter(Writer out, Configuration config) {
    this.out = out;
    if (config != null)
      this.idprops = config.getIdentityProperties();
  }

  public void write(no.priv.garshol.duke.Record r1, no.priv.garshol.duke.Record r2, boolean match, double confidence)
    throws IOException {
    write(getid(r1), getid(r2), match, confidence);
  }

  public void write(String id1, String id2, boolean match, double confidence)
    throws IOException {
    out.write("" + (match ? "+," : "-,") + id1 + ',' + id2 + ',' + confidence +
              "\n");
  }
  
  private String getid(no.priv.garshol.duke.Record r) {
    for (Property p : idprops) {
      String v = r.getValue(p.getName());
      if (v == null)
        continue;

      return v;
    }

    throw new DukeException("No identity for record " + r);
  }
}