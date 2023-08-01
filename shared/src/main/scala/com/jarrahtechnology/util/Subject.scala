package com.jarrahtechnology.util

final class Subject[T] {
  private val listeners = collection.mutable.HashSet.empty[T => Unit]
  def size() = listeners.size
  def add(listener: T => Unit) = { listeners += listener; listener.hashCode }
  def remove(code: Int): Unit = listeners.filterInPlace(_.hashCode != code)
  def clear() = listeners.clear()
  def notify(ev: T) = listeners.foreach(_(ev))
}
