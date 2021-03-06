package com.dzt.btcommunication.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dzt.btcommunication.R;
import com.dzt.btcommunication.javabean.SiriListItem;

import java.util.List;

public class ChatListAdapter extends AbsListAdapter<SiriListItem> {

	public ChatListAdapter(Context context, List<SiriListItem> datas) {
		super(context, datas);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		SiriListItem item = datas.get(position);
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.list_item, null);
			viewHolder = new ViewHolder(
					convertView.findViewById(R.id.list_child),
					(TextView) convertView.findViewById(R.id.chat_msg)
			);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		if (item.isSiri) {
			viewHolder.child.setBackgroundResource(R.drawable.msgbox_rec);
		} else {
			viewHolder.child.setBackgroundResource(R.drawable.msgbox_send);
		}
		viewHolder.msg.setText(item.message);

		return convertView;
	}

	class ViewHolder {
		protected View child;
		protected TextView msg;

		public ViewHolder(View child, TextView msg) {
			this.child = child;
			this.msg = msg;

		}
	}
}
