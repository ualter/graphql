package com.graphql.mortgages.error.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class LenderNotFoundException extends RuntimeException implements GraphQLError {

	private static final long serialVersionUID = -1191946046714716401L;
	
	private Map<String, Object> extensions = new HashMap<>();

	public LenderNotFoundException(String message, Long invalidLenderId) {
		super(message);
		extensions.put("invalidLenderId", invalidLenderId);
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public Map<String, Object> getExtensions() {
		return extensions;
	}

	@Override
	public ErrorType getErrorType() {
		return ErrorType.DataFetchingException;
	}
}