package no.priv.garshol.duke.datasources;

import no.priv.garshol.duke.*;
import no.priv.garshol.duke.utils.DefaultRecordIterator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Data source which can be passed Record objects, and which then
 * returns them.
 * @since 0.4
 */
public class InMemoryDataSource implements DataSource {
  /**
   * The records held by the data source.
   */
  protected Collection<no.priv.garshol.duke.Record> records;

  /**
   * Creates an empty source.
   */
  public InMemoryDataSource() {
    this.records = new ArrayList<no.priv.garshol.duke.Record>();
  }

  /**
   * Creates a source populated with the records in the
   * <tt>records</tt> parameter.
   */
  public InMemoryDataSource(Collection<no.priv.garshol.duke.Record> records) {
    this.records = records;
  }

  @Override
  public RecordIterator getRecords() {
    return new DefaultRecordIterator(records.iterator());
  }

  /**
   * Removes all records held by the data source.
   */
  public void clear() {
    records.clear();
  }

  /**
   * Adds a record to the collection held by the source.
   */
  public void add(no.priv.garshol.duke.Record record) {
    records.add(record);
  }

  public void setLogger(Logger logger) {
    // there's not really much to log here, so...
  }

  @Override
  public void writeConfig(ConfigWriter cw) {
    String name = "memory";
    cw.writeStartElement(name, null);
    cw.writeEndElement(name);
  }
}