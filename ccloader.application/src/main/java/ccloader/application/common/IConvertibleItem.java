package ccloader.application.common;

public interface IConvertibleItem<T> {

	public void convertFrom(T model);
	
	public T convertTo();
}
