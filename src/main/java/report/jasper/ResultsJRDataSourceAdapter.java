package report.jasper;

import java.util.HashMap;
import java.util.Map;

import model.money.MoneyAmount;
import model.util.Percentage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import org.apache.commons.collections.Transformer;
import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.base.BaseDateTime;
import org.joda.time.format.DateTimeFormat;

import query.framework.results.SearchResults;

//TODO Move reutilizable adaptation methods to another class.

public class ResultsJRDataSourceAdapter implements JRDataSource {

	private final SearchResults results;
	private int currentRowIndex = -1;
	private static final Map<Class<?>, Transformer> valueTransformerMap = new HashMap<Class<?>, Transformer>();
	private static final Map<Class<?>, Class<?>> valueTransformerResultClassMap = new HashMap<Class<?>, Class<?>>();
	private static Transformer defaultValueTransformer = new Transformer() {
		public Object transform(Object value) {
			return value.toString();
		}
	};
	private static final Class<?> defaultValueResultClass = String.class; 

	static {
		addValueTransformer(MoneyAmount.class, Double.class, new Transformer() {
			public Object transform(Object value) {
				return ((MoneyAmount) value).value();
			}
		});
		
		addValueTransformer(Percentage.class, Double.class, new Transformer() {
			public Object transform(Object value) {
				return ((Percentage) value).value();
			}
		});
		
		Transformer jodaInstantTransformer = new Transformer() {
			public Object transform(Object value) {
				return DateTimeFormat.shortDateTime().print(((ReadableInstant) value));
			}
		};
		addValueTransformer(ReadableInstant.class, String.class, jodaInstantTransformer);
		addValueTransformer(BaseDateTime.class, String.class, jodaInstantTransformer);
		addValueTransformer(DateTime.class, String.class, jodaInstantTransformer);
		
//		TODO showTransformers.put(CashBookEntry.class, CashBookCellRenderer.instance());
		
		Transformer identityTransformer = new Transformer() {
			public Object transform(Object value) {
				return value;
			}
		};
		addValueTransformer(Integer.class, Integer.class, identityTransformer);
		addValueTransformer(Long.class, Long.class, identityTransformer);
		addValueTransformer(Double.class, Double.class, identityTransformer);
	}
	
	public ResultsJRDataSourceAdapter(SearchResults results) {
		this.results = results;
	}

	private static void addValueTransformer(Class<?> keyClass, Class<?> transformedClass, Transformer transformer) {
		valueTransformerMap.put(keyClass, transformer);
		valueTransformerResultClassMap.put(keyClass, transformedClass);
	}

	public Object getFieldValue(JRField field) throws JRException {
		for (int i = 0; i < results.getColumnCount(); i++) {
			if (field.getName().equals(results.getColumnName(i))) {
				return adaptedValueFor(results.getValueAt(currentRowIndex, i));
			}
		}
		throw new Error("Invalid column: " + field.getName());
	}

	public static Object adaptedValueFor(Object value) {
		Transformer transformer = valueTransformerMap.get(value.getClass());
		if (transformer == null) {
			return defaultValueTransformer.transform(value);
		} else {
			return transformer.transform(value);
		}
	}
	
	public boolean next() throws JRException {
		if (currentRowIndex < results.getRowCount() - 1) {
			currentRowIndex++;
			return true;
		} else {
			return false;
		}
	}

	public static Class adaptedClassFor(Class<?> clazz) {
		Class<?> resultClass = valueTransformerResultClassMap.get(clazz);
		if (resultClass == null) {
			return defaultValueResultClass;
		} else {
			return resultClass;
		}
	}

}
