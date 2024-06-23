
package no.priv.garshol.duke.utils;

import no.priv.garshol.duke.Record;
import no.priv.garshol.duke.RecordIterator;

import java.util.Iterator;

public class DefaultRecordIterator extends RecordIterator {
  private Iterator<no.priv.garshol.duke.Record> it;
  
  public DefaultRecordIterator(Iterator<no.priv.garshol.duke.Record> it) {
    this.it = it;
  }

  public boolean hasNext() {
    return it.hasNext();
  }

  public no.priv.garshol.duke.Record next() {
    return it.next();
  }  
}