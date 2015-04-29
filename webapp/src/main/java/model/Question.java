package model;

import java.sql.Clob;

/**
 * @author yxx03
 * 
 */

public class Question {
	int id;
	Clob question;
	Type type;
	int difficultyLevel;
	Clob answerJSON;
	char status;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the question
	 */
	public Clob getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(Clob question) {
		this.question = question;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @return the difficultyLevel
	 */
	public int getDifficultyLevel() {
		return difficultyLevel;
	}

	/**
	 * @param difficultyLevel
	 *            the difficultyLevel to set
	 */
	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	/**
	 * @return the answerJSON
	 */
	public Clob getAnswerJSON() {
		return answerJSON;
	}

	/**
	 * @param answerJSON
	 *            the answerJSON to set
	 */
	public void setAnswerJSON(Clob answerJSON) {
		this.answerJSON = answerJSON;
	}

	/**
	 * @return the status
	 */
	public char getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(char status) {
		this.status = status;
	}

}
