/**
 * 
 */
package model;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * @author yxx03
 * 
 */
public class UsageStat {
	int questionId;
	int finalUsedCount;
	int previewGenerateCount;
	Timestamp lastDateUsed;
	Timestamp lastDatePreviewed;

	/**
	 * @return the questionId
	 */
	public int getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId
	 *            the questionId to set
	 */
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the finalUsedCount
	 */
	public int getFinalUsedCount() {
		return finalUsedCount;
	}

	/**
	 * @param finalUsedCount
	 *            the finalUsedCount to set
	 */
	public void setFinalUsedCount(int finalUsedCount) {
		this.finalUsedCount = finalUsedCount;
	}

	/**
	 * @return the previewGenerateCount
	 */
	public int getPreviewGenerateCount() {
		return previewGenerateCount;
	}

	/**
	 * @param previewGenerateCount
	 *            the previewGenerateCount to set
	 */
	public void setPreviewGenerateCount(int previewGenerateCount) {
		this.previewGenerateCount = previewGenerateCount;
	}

	/**
	 * @return the lastDateUsed
	 */
	public Timestamp getLastDateUsed() {
		return lastDateUsed;
	}

	/**
	 * @param lastDateUsed
	 *            the lastDateUsed to set
	 */
	public void setLastDateUsed(Timestamp lastDateUsed) {
		this.lastDateUsed = lastDateUsed;
	}

	/**
	 * @return the lastDatePreviewed
	 */
	public Timestamp getLastDatePreviewed() {
		return lastDatePreviewed;
	}

	/**
	 * @param lastDatePreviewed
	 *            the lastDatePreviewed to set
	 */
	public void setLastDatePreviewed(Timestamp lastDatePreviewed) {
		this.lastDatePreviewed = lastDatePreviewed;
	}

}
