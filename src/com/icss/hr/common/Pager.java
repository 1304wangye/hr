package com.icss.hr.common;

/**
 * ��ҳ������
 * 
 * @author DLETC
 *
 */
public class Pager {

	private int recordCount;// �ܼ�¼��

	private int pageSize = 10;// ÿҳ������

	private int pageCount;// ����ҳ

	private int pageNum;// ��ǰ�ǵڼ�ҳ

	private int start;// ��ʼλ��

	public Pager(int recordCount, int pageSize, int pageNum) {

		this.recordCount = recordCount;
		this.pageSize = pageSize;
		this.pageNum = pageNum;

		// ���㹲��ҳ
		this.pageCount = this.recordCount / this.pageSize;
		if (this.recordCount % this.pageSize != 0)
			this.pageCount++;

		// ���㵱ǰҳ��
		if (this.pageNum < 1)
			this.pageNum = 1;

		if (this.pageNum > this.pageCount)
			this.pageNum = this.pageCount;

		// ������ʼλ��
		this.start = (this.pageNum - 1) * this.pageSize + 1;

	}
	
	public Pager(int recordCount, int pageNum) {

		this.recordCount = recordCount;
		this.pageNum = pageNum;

		// ���㹲��ҳ
		this.pageCount = this.recordCount / this.pageSize;
		if (this.recordCount % this.pageSize != 0)
			this.pageCount++;

		// ���㵱ǰҳ��
		if (this.pageNum < 1)
			this.pageNum = 1;

		if (this.pageNum > this.pageCount)
			this.pageNum = this.pageCount;

		// ������ʼλ��
		this.start = (this.pageNum - 1) * this.pageSize + 1;

	}

	public int getRecordCount() {
		return recordCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getStart() {
		return start;
	}

}