package dao;

import java.util.List;

import pojos.Method;
import pojos.TranslatedMethod;

public interface MethodsDAO {

	public int insertMethod(Method method) throws Exception;

	public int insertTranslatedMethod(TranslatedMethod translatedMethod) throws Exception;

	public int deleteMethod(Method method) throws Exception;

	public int deleteTranslatedMethod(TranslatedMethod translatedMethod) throws Exception;
	
	public int updateMethod(Method currentMethod, Method updatedMethod) throws Exception;

	public int updateTranslatedMethod(TranslatedMethod currentTranslatedMethod, TranslatedMethod updatedTranslatedMethod) throws Exception;

	public List<Method> findAllMethods() throws Exception;

	public List<TranslatedMethod> findGrMethods() throws Exception;

	public List<TranslatedMethod> findEnMethods() throws Exception;

}
