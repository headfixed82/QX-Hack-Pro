package com.qxpro.app
import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.provider.Settings
import android.view.Gravity
import android.widget.*
class MainActivity: Activity() {
 override fun onCreate(b: Bundle?) { super.onCreate(b); ui() }
 private fun ui() {
  val root=LinearLayout(this); root.orientation=LinearLayout.VERTICAL; root.setPadding(32,42,32,32); root.setBackgroundColor(Color.rgb(5,7,11))
  val title=TextView(this); title.text="QX PRO"; title.textSize=30f; title.setTextColor(Color.rgb(0,229,255)); title.gravity=Gravity.CENTER
  val sub=TextView(this); sub.text="Technical Market Analyzer"; sub.textSize=14f; sub.setTextColor(Color.LTGRAY); sub.gravity=Gravity.CENTER; sub.setPadding(0,8,0,28)
  val perm=Button(this); perm.text="ALLOW FLOATING WINDOW"; perm.setOnClickListener {
   if(!Settings.canDrawOverlays(this)) startActivity(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,Uri.parse("package:$packageName")))
   else Toast.makeText(this,"Permission already enabled",Toast.LENGTH_SHORT).show()
  }
  val start=Button(this); start.text="START QX PRO"; start.setOnClickListener { Toast.makeText(this,"Starter ready",Toast.LENGTH_SHORT).show() }
  val info=TextView(this); info.text="\nSTATUS\n• AndroidIDE-ready\n• Compile SDK 34\n• Build Tools 34.0.4\n\nNext: floating overlay + screen capture + technical analysis."
  info.textSize=15f; info.setTextColor(Color.WHITE)
  root.addView(title);root.addView(sub);root.addView(perm);root.addView(start);root.addView(info);setContentView(root)
 }
}
